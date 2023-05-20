export interface User {
  firstName: string;
  lastName: string;
  iban: string;
  email: string;
  active: boolean;
  userRole: UserRole;
  profile: Profile;
}

export interface UserRole {
  role: string;
}

export interface Profile {
  id: number;
  password?: string;
  username?: string;
}
