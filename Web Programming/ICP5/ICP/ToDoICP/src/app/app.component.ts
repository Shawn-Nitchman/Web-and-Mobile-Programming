import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  todoArray = [];
  todo;

  addTodo(value) {
    this.todoArray.push(value);
  }


  // Write code to complete item
   completeItem(todo) {
     for (let i = 0; i <= this.todoArray.length; i++) {
       if (todo === this.todoArray[i]) {
         console.log('cross');
       }
     }
    }

  // Write code to delete item
  deleteItem(todo) {
    for (let i = 0; i <= this.todoArray.length; i++) {
      if (todo === this.todoArray[i]) {
        this.todoArray.splice(i, 1);
      }
    }
  }

  todoSubmit(value: any) {
    if ( value !== '') {
      this.todoArray.push(value.todo);
    } else {
      alert('Field required **');
    }
  }


}
