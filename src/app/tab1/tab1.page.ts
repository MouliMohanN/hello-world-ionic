import { Component } from '@angular/core';
import { IonHeader, IonToolbar, IonTitle, IonContent, IonButton } from '@ionic/angular/standalone';
import { ExploreContainerComponent } from '../explore-container/explore-container.component';
import Security from 'src/plugins/securityPlugin';
import {  CommonModule } from '@angular/common';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss'],
  standalone: true,
  imports: [IonHeader, IonToolbar, IonTitle, IonContent, ExploreContainerComponent, IonButton,  CommonModule],
})
export class Tab1Page {

  message: string = 'Initial Value'
  isSecure: boolean = false
  title: string = ''
  description: string = ''

  constructor() {}
  

  async onButtonPress() {
    console.log('button pressed');
    setTimeout(() => {
      Security.isAppSecure()
    }, 30)
    setTimeout(() => {
      Security.isAppSecure()
    }, 60)
    setTimeout(() => {
      Security.isAppSecure()
    }, 90)
    setTimeout(() => {
      Security.isAppSecure()
    }, 120)
    const { isSecure: isAppSecure, title: alertTitle, message: alertDescription } = await Security.isAppSecure();
    // const isAppSecure = true
    // const alertTitle = 'Title'
    // const alertDescription = 'Desc'
    this.isSecure = !this.isSecure
    if (alertTitle && alertDescription) {
      this.title = alertTitle
      this.description = alertDescription
    }
  }
}
