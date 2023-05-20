import { Category } from './category';
import { Profile } from './user';

export interface Clothes {
  id?: number;
  name: string;
  description: string;
  size: string;
  price: number;
  picture?: string | null; // Changed type to string | null
  profile?: Profile;
  category?: Category;
  imageUrl?: string;
}
