import { iTelefono } from './i-telefono';

export interface JsonContent {
  products: iTelefono[];
  total: number;
  skip: number;
  limit: number;
}
