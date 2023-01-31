export interface Product {
    id?: number
    name?: string
    price?: number
    stock?: number
    factoryLaboratory?: string
    dateManufacture?: string
    dateExpiration?: string


    dateTimeManufacture?: Date
    dateTimeExpiration?: Date
}