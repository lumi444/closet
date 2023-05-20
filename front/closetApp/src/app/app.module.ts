import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './modules/login/login.component';
import { NavigationComponent } from './modules/navigation/navigation.component';
import { ClosetComponent } from './modules/closet/closet.component';
import { HomeComponent } from './modules/home/home.component';
import { ArticleComponent } from './modules/article/article.component';
import { BoardComponent } from './modules/board/board.component';
import { MainComponent } from './modules/main/main.component';
import { SidebarComponent } from './modules/sidebar/sidebar.component';
import { ProfileComponent } from './modules/profile/profile.component';
import { MatMenuModule } from '@angular/material/menu';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatIconModule } from '@angular/material/icon';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddFormComponent } from './modules/add-form/add-form.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavigationComponent,
    ClosetComponent,
    HomeComponent,
    ArticleComponent,
    BoardComponent,
    MainComponent,
    SidebarComponent,
    ProfileComponent,
    AddFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatMenuModule,
    MatExpansionModule,
    MatIconModule,
    BrowserAnimationsModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
