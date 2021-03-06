import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { User } from '../../models/user.model';

/**
  *Service for handling data from the back-end
  *i.e. login data, client data, and etc
  */
@Injectable()
export class RequestService {

  host: string = environment.url;
  trackPath: string = this.host + 'TrackForce/';

  /**
    *@param {HttpClient} http
    *Need to create a connection to REST endpoint
    *And initiate Http requests
    */
  constructor(private http: HttpClient) { }

  public populateDB(): Observable<boolean> {
    return this.http.get<boolean>(this.trackPath + 'database/populateDB');
  }

  public populateDBSF(): Observable<boolean> {
    return this.http.get<boolean>(this.trackPath + 'database/populateDBSF');
  }

  public deleteDB(): Observable<boolean> {
    return this.http.delete<boolean>(this.trackPath + 'database/deleteFromDB');
  }

  public getStatuses(): Observable<boolean> {
    return this.http.get<boolean>(this.trackPath + 'marketing');
  }

}
