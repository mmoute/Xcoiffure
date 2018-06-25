import { Injectable } from '@angular/core';
import {Employes} from './employes';
import {AppConfigService} from '../app-config.service';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class ApiEmployesService {
  constructor(private appConfig: AppConfigService, private http: HttpClient) {
  }

  public findAll(): Observable<Employes[]> {
    return this.http.get<Employes[]>(`${this.appConfig.url}/employes`);
  }

  public create(employes: Employes): Observable<void> {
    return this.http.post<void>(`${this.appConfig.url}/employes`, employes);
  }

  public findById(id: number): Observable<Employes> {
    return this.http.get<Employes>(`${this.appConfig.url}/employes/` + id);
  }

  public update(employes: Employes): Observable<void> {
    return this.http.put<void>(`${this.appConfig.url}/employes/` + employes.id, employes);
  }

  public deleteById(id: number): Observable<void> {
    return this.http.delete<void>(`${this.appConfig.url}/employes/` + id);
  }
}
