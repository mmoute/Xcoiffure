import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {AccueilComponent} from './Accueil/accueil.component';
import {HttpClientModule} from '@angular/common/http';
import {EntrepriseModule} from './Entreprise/entreprise.module';
import {EmployesModule} from './Employes/employes.module';
import {ServiceModule} from './Service/service.module';
import {ClientModule} from './Client/client.module';
import {RdvModule} from './RDV/rdv.module';
import {AccueilModule} from './Accueil/accueil.module';
import {ConnexionComponent} from './connexion.component';
import {AdresseModule} from './Adresse/adresse.module';


const routes: Routes = [
  {path: 'connexion', component: AccueilComponent},
  {path: '', redirectTo: 'accueil', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent, ConnexionComponent
  ],
  imports: [
    BrowserModule, FormsModule, RouterModule.forRoot(routes),
    HttpClientModule, ClientModule, EntrepriseModule,
    RdvModule, ServiceModule, EmployesModule, AccueilModule, AdresseModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
