import { Component } from '@angular/core';
import { Platform, IonApp, IonRouterOutlet } from '@ionic/angular/standalone';
import Security from 'src/plugins/securityPlugin';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  standalone: true,
  imports: [IonApp, IonRouterOutlet],
})
export class AppComponent {
  constructor(private platform: Platform) {
    this.platform.ready().then(async() => {
      console.log('Platform ready');
      const { isSecure: isAppSecure, title: alertTitle, message: alertDescription } = await Security.isAppSecure();
      alert(`${isAppSecure} ${alertTitle} ${alertDescription}`)
    })
  }
  
}
