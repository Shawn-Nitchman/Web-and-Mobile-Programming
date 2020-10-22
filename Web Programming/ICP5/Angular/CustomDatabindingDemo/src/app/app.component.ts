import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'CustomDatabindingDemo';

  TestObject = {type: 'server', name: 'Testserver', content: 'I am a test for server!'};

  onObjectAdded(objectData: {objectName: string, objectContent: string}) {
    this.TestObject= {
      type: 'server',
      name: objectData.objectName,
      content: objectData.objectContent
    };
  }
}
