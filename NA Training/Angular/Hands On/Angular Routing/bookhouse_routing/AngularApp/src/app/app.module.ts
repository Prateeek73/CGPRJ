import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';

import { PurchaseComponent } from './purchase/purchase.component';
import { Routes, RouterModule } from '@angular/router';
import { PaymentComponent } from './payment/payment.component';
import { MembershipComponent } from './membership/membership.component';

export const routes: Routes = [
  // Fill the code to define the route
  { path: 'purchase', component: PurchaseComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'membership', component: MembershipComponent },
  { path: '', redirectTo: '/purchase', pathMatch: 'full' },
];

@NgModule({
  declarations: [
    AppComponent,
    PurchaseComponent,
    PaymentComponent,
    MembershipComponent,
  ],
  imports: [BrowserModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
