import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LocalStorageDemo';


  logins = [];
  firstName: String = '';
  pwd: String = '';

  login(username, pwd) {
    localStorage.setItem('name', username);
    this.logins.push(localStorage.getItem('name') + ' was logged in.');
  }
}
