import { Component } from '@angular/core';
import { IonHeader, IonToolbar, IonTitle, IonContent, IonButton } from '@ionic/angular/standalone';
import { ExploreContainerComponent } from '../explore-container/explore-container.component';
import Echo from 'src/plugins/echoPlugin';
import Security from 'src/plugins/securityPlugin';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss'],
  standalone: true,
  imports: [IonHeader, IonToolbar, IonTitle, IonContent, ExploreContainerComponent, IonButton],
})
export class Tab1Page {

  message: string = 'Initial Value'
  isSecure: boolean = false

  constructor() {}

  async onButtonPress() {
    console.log('button pressed');
    const { value } = await Echo.echo({ value: 'Hello World!' });
    // const value = 'Hello World!'
    console.log('Response from native:', value);
    this.message = `${value} from Native`
    this.isSecure = (await Security.isAppSecure()).isSecure;
  }
}
