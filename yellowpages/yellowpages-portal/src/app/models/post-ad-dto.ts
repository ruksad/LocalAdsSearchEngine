import { AttributeDTO } from './attribute-dto';
export class PostAdDto {
    objectTypeLevel2CategoryId:number;
    objectTypeId:number;
    cityId:number;
    localityId:number;
    attributeDTOList:AttributeDTO[];
    objectDescription:string;
    name:string;
    constructor(res:any){
        Object.assign(this,res);        
    }
}

