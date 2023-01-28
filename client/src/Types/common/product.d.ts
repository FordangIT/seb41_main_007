export interface TYPE_Product {
  productId: number;
  name: string;
  price: number;
  photo: string;
  alt?: string;
  isNew: boolean;
  isBest: boolean;
}

export interface TYPE_PageInfo {
  page: number;
  size: number;
  totalElements: number;
  totalPages: number;
}
// productOptionId: number;
// productOptionName: string;
// price: number;
// stock: number;

export interface TYPE_ProductOption {
  productOptionId: number;
  productOptionName: string;
  price: number;
  stock: number;
}

export interface TYPE_LocalOption {
  id: number;
  price: number;
  optionprice: number;
  optionname: string;
  count: number;
  productOptionId: number;
}

export interface counttype {
  id: number;
  price: number;
  count: number;
  optionprice: number;
  optionname: string;
  productOptionId: number;
}
