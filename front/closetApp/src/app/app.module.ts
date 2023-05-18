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

@NgModule({
  declarations: [AppComponent, LoginComponent, NavigationComponent, ClosetComponent, HomeComponent, ArticleComponent, BoardComponent, MainComponent, SidebarComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
