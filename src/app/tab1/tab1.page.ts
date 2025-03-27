import { Component } from '@angular/core';
import { IonHeader, IonToolbar, IonTitle, IonContent, IonButton } from '@ionic/angular/standalone';
import { ExploreContainerComponent } from '../explore-container/explore-container.component';
import {  CommonModule } from '@angular/common';
import SecurityPlugin, { SecurityType } from 'src/plugins/securityPlugin';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss'],
  standalone: true,
  imports: [IonHeader, IonToolbar, IonTitle, IonContent, ExploreContainerComponent, IonButton,  CommonModule],
})
export class Tab1Page {

  message: string = 'Initial Value'
  type: string = 'NULL'
  title: string = ''
  description: string = ''

  constructor() {}
  

  async onButtonPress() {
    console.log('button pressed');
    // setTimeout(() => {
    //   Security.isAppSecure()
    // }, 30)
    // setTimeout(() => {
    //   Security.isAppSecure()
    // }, 60)
    // setTimeout(() => {
    //   Security.isAppSecure()
    // }, 90)
    // setTimeout(() => {
    //   Security.isAppSecure()
    // }, 120)
    const { type: securityType, title: alertTitle, message: alertDescription } = await SecurityPlugin.isAppSecure();
    this.type = securityType
    if (securityType === SecurityType.NONE) {
      this.title = 'All Good'
      this.description = ""
    } else if (securityType === SecurityType.DEVELOPER_OPTIONS) {
      this.title = "It is okay to use the app"
      this.description = ""
    } else {
      this.title = alertTitle
      this.description = alertDescription
    }
    
  }
}
