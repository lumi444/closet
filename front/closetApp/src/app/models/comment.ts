import { Clothes } from './clothes';
import { Profile } from './user';

export interface Comment {
  id: number;
  content: string;
  posting_date: Date;
  clothes: Clothes;
  profile: Profile;
}
