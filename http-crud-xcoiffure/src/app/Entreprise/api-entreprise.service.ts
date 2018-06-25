import { Injectable } from '@angular/core';
import {AppConfigService} from '../app-config.service';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Entreprise} from './entreprise';

@Injectable()
export class ApiEntrepriseService {

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
  }

  public findAll(): Observable<Entreprise[]> {
    return this.http.get<Entreprise[]>(`${this.appConfig.url}/entreprise`);
  }

  public create(entreprise: Entreprise): Observable<void> {
    return this.http.post<void>(`${this.appConfig.url}/entreprise`, entreprise);
  }

  public findById(id: number): Observable<Entreprise> {
    return this.http.get<Entreprise>(`${this.appConfig.url}/entreprise/` + id);
  }

  public update(entreprise: Entreprise): Observable<void> {
    return this.http.put<void>(`${this.appConfig.url}/entreprise/` + entreprise.id, entreprise);
  }

  public deleteById(id: number): Observable<void> {
    return this.http.delete<void>(`${this.appConfig.url}/entreprise/` + id);
  }

}
