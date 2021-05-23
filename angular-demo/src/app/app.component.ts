import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

@Injectable()
export class AppComponent implements OnInit {
  title: string = 'angular-demo';
  api: string = 'http://localhost:8080/students';
  people: PersonDto[] = [];
  constructor(private httpClient: HttpClient) { 
    this.getAll().subscribe(res => this.people = res);
  }

  ngOnInit(): void {
    this.getAll().subscribe(res => this.people = res);
  }

  //todo to leard -> follow this article https://florimond.dev/en/posts/2018/09/consuming-apis-in-angular-the-model-adapter-pattern/

  getAll(): Observable<PersonDto[]> {
    const url = `${this.api}/`;
    return this.httpClient.get(this.api)
      .pipe(
        map((data: any[]) => 
          data.map(
            (item: any) =>
              new PersonDto(item.id, item.name, item.surname, new Date(item.birthDate))
            )
          )
      );
  }

}

export class PersonDto {
  constructor(
    public id: Number,
    public name: string,
    public surname: string,
    public birthDate: Date
  ) {}
}
