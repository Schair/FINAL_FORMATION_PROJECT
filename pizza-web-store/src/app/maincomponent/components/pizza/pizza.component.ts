import { Component, Input, OnInit, Output } from '@angular/core';
import { Pizza } from '../../interfaces/pizza';

@Component({
  selector: 'app-pizza',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.scss']
})
export class PizzaComponent implements OnInit {

  @Input() pizza!: Pizza;
  // TODO: Generate output
  //@Output()

  constructor() { }

  ngOnInit(): void {
  }

}
