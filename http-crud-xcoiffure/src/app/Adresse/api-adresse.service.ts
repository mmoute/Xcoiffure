import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {AppConfigService} from '../app-config.service';
import {HttpClient} from '@angular/common/http';
import {Adresse} from './adresse';

@Injectable()
export class ApiAdresseService {

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
  }

  public findAll(): Observable<Adresse[]> {
    return this.http.get<Adresse[]>(`${this.appConfig.url}adresse`);
  }

  public create(adresse: Adresse): Observable<void> {
    return this.http.post<void>(`${this.appConfig.url}adresse`, adresse);
  }

  public findById(id: number): Observable<Adresse> {
    return this.http.get<Adresse>(`${this.appConfig.url}adresse/` + id);
  }

  public update(adresse: Adresse): Observable<void> {
    return this.http.put<void>(`${this.appConfig.url}adresse/` + adresse.id, adresse);
  }

  public deleteById(id: number): Observable<void> {
    return this.http.delete<void>(`${this.appConfig.url}adresse/` + id);
  }

}
