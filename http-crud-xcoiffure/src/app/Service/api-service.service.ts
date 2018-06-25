import { Injectable } from '@angular/core';
import {AppConfigService} from '../app-config.service';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Service} from './service';

@Injectable()
export class ApiServiceService {

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
  }

  public findAll(): Observable<Service[]> {
    return this.http.get<Service[]>(`${this.appConfig.url}/service`);
  }

  public create(service: Service): Observable<void> {
    return this.http.post<void>(`${this.appConfig.url}/service`, service);
  }

  public findById(id: number): Observable<Service> {
    return this.http.get<Service>(`${this.appConfig.url}/service/` + id);
  }

  public update(service: Service): Observable<void> {
    return this.http.put<void>(`${this.appConfig.url}/service/` + service.id, service);
  }

  public deleteById(id: number): Observable<void> {
    return this.http.delete<void>(`${this.appConfig.url}/service/` + id);
  }
}
