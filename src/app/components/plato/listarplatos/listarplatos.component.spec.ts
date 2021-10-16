import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarplatosComponent } from './listarplatos.component';

describe('ListarplatosComponent', () => {
  let component: ListarplatosComponent;
  let fixture: ComponentFixture<ListarplatosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarplatosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarplatosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
