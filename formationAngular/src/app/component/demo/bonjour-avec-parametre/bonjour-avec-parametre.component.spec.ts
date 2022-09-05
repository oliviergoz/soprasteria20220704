import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BonjourAvecParametreComponent } from './bonjour-avec-parametre.component';

describe('BonjourAvecParametreComponent', () => {
  let component: BonjourAvecParametreComponent;
  let fixture: ComponentFixture<BonjourAvecParametreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BonjourAvecParametreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BonjourAvecParametreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
