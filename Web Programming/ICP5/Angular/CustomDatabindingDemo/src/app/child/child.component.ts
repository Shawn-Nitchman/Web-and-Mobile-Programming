import {Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  @Output() objectCreated = new EventEmitter<{objectName: string, objectContent: string}>(); //event binding

  @Input('testObj') element: {type: string, name: string, content: string}; // property binding

  @ViewChild('objectContent') objectContent: ElementRef;


  constructor() { }

  ngOnInit() {
  }

  onAddObject(nameInput: HTMLInputElement) { //event binding
    this.objectCreated.emit({
      objectName: nameInput.value,
      objectContent: this.objectContent.nativeElement.value
    });
  }

}
