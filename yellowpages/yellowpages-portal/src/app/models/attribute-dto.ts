import { ListDto } from './list-dto';
export class AttributeDTO{
    attributeId:number;
    attributeName:string;
    attributeDescription:string;
    listValues:ListDto[];
    /** either parameter value will be present or the selected listDTO value **/
    parameterValue:string;
    selectedListValue:ListDto;
    /** attribute is drop down or text for UI**/
    attributeType:string;   
    others:any;
}