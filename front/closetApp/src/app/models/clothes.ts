import { Category } from './category';
import { Profile } from './user';

export interface Clothes {
  name: string;
  description: string;
  size: string;
  price: number;
  picture: ArrayBuffer;
  profile: Profile;
  category: Category;
  imageUrl?: string;
}
