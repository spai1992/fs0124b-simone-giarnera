import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IncompletiComponent } from './incompleti.component';

describe('IncompletiComponent', () => {
  let component: IncompletiComponent;
  let fixture: ComponentFixture<IncompletiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [IncompletiComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IncompletiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
