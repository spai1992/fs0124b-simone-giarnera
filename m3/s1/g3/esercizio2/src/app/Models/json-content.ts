import { iArticolo } from './articolo';

export interface iJsonContent {
  posts: iArticolo[];
  total: number;
  skip: number;
  limit: number;
}
