import { OrderStatus } from './order_status';
import { Reservation } from './reservation';

export interface Order {
  id: number;
  card_number: string;
  delivery_address: string;
  price: number;
  reservartion: Reservation;
  status: OrderStatus;
}
