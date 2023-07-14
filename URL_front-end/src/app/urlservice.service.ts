import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { url } from './urlModel';
@Injectable({
  providedIn: 'root'
})
export class UrlserviceService {
  private baseUrl='http://localhost:8888/Api/url';
  constructor(private httpClient:HttpClient) { }

  getUrl(Lurl:url):Observable<url> {
    return this.httpClient.post<url>(`${this.baseUrl}`,Lurl);
  }
}
