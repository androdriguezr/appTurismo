import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarplatosComponent } from './agregarplatos.component';

describe('AgregarplatosComponent', () => {
  let component: AgregarplatosComponent;
  let fixture: ComponentFixture<AgregarplatosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgregarplatosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AgregarplatosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
