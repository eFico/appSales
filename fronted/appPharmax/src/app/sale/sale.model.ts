import { Product } from "../product/product.model"

export interface Sale {
    id?: number
    product?: Product
    quantity?: number
    price?: number
    totalPrice?: number
    date?: string

    dateTime?: Date
}