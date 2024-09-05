export interface Album {
  id: string;
  ref: string;
  name: string;
  title: string;
  description: string;
  author?: string;
  duration: number;
  url?: string;
  like?: string;
  tags?: string[];
  status?: string;
  createdAt?: String;
  updatedAt?: String;
  albumFavoris?: [];
  musiques?: [];
}
