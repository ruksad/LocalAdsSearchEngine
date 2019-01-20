package com.yellowpages.utils;

import com.yellowpages.model.*;
import com.yellowpages.model.dto.FlattenedObjectEntityDto;
import com.yellowpages.model.dto.PostAdDto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * Created by Ruksad siddiqui on 5/3/18
 */
public class CommonUtils {

    public static List<ObjectEntity> removeDuplicateObjectFromListOfObjects(List<ObjectEntity> list) {
        return list.stream().collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingLong(ObjectEntity::getObjectId))), ArrayList::new));
    }

    public static <T extends Enum<T>> List<Long> enumToLongList(Class<T> clzz) {

        try {
            List<Long> values = new LinkedList<>();
            Method displayValue = clzz.getMethod("getDisplayValue");
            for (Object object : clzz.getEnumConstants()) {
                values.add((Long) displayValue.invoke(object));
            }
            return values;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<FlattenedObjectEntityDto> getFlattenedObjectEntityDtos(List<ObjectEntity> objectEntities) {
        List<FlattenedObjectEntityDto> flattenedObjectEntityDtos = new ArrayList<>();
        if (Objects.nonNull(objectEntities) && !objectEntities.isEmpty()) {
            objectEntities = removeDuplicateObject(objectEntities);
            objectEntities.forEach(x -> {
                FlattenedObjectEntityDto flattenedObjectEntityDto = FlattenedObjectEntityDto.from(x);
                flattenedObjectEntityDtos.add(flattenedObjectEntityDto);
            });

            return flattenedObjectEntityDtos;
        }
        return null;
    }


    public static List<ObjectEntity> removeDuplicateObject(List<ObjectEntity> list) {
        return CommonUtils.removeDuplicateObjectFromListOfObjects(list);
    }

    public static String currentDateInUTCInString(){
        TimeZone timeZone = TimeZone.getTimeZone(AppConstants.UTC);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AppConstants.YP_DATE_FORMAT);
        simpleDateFormat.setTimeZone(timeZone);
       return simpleDateFormat.format(new Date());
    }

    public static String idsInListToString(List<Long> ids){
        if(Objects.nonNull(ids)&& !ids.isEmpty()){
           return ids.stream().map(Object::toString).collect(Collectors.joining(","));
        }
        return "";
    }

    public static boolean validatePhoneNumber(String phoneNumber){
        String regex = "^\\+?[0-9. ()-]{10,25}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
