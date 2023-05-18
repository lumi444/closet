import { Clothes } from './clothes';
import { Profile } from './user';

export interface Reservation {
  id: number;
  reservation_date: Date;
  return_date: Date;
  clothes: Clothes;
  profile: Profile;
}
