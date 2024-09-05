import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlbumCreateFormComponent } from './album-create-form.component';

describe('AlbumCreateFormComponent', () => {
  let component: AlbumCreateFormComponent;
  let fixture: ComponentFixture<AlbumCreateFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AlbumCreateFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AlbumCreateFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
