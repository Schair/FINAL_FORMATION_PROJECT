import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';

import { BreakpointObserver } from '@angular/cdk/layout';
@Component({
  selector: 'app-responsive-nav',
  templateUrl: './responsive-nav.component.html',
  styleUrls: ['./responsive-nav.component.scss']
})
export class ResponsiveNavComponent implements OnInit {

  @ViewChild(MatSidenav) sidenav!: MatSidenav;
  logoPath: string;

  constructor(public observer: BreakpointObserver) { 
    this.logoPath = '/assets/img/pizza.png';
  }

  ngAfterViewInit(){
    this.observer.observe(['(max-width: 800px)']).subscribe((res) => {
      if (res.matches) {
        this.sidenav.mode = 'over';
        this.sidenav.close();
      } else {
        this.sidenav.mode = 'side';
        this.sidenav.open();
      }
    });
  }

  ngOnInit(): void {
  }

}
