import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from "@angular/router";
import { MainSearchPageComponent } from "./components/main-search-page/main-search-page.component";
import { ForSalePagesComponent } from './components/for-sale-pages/for-sale-pages.component';
import { PostAddComponent } from './components/post-add/post-add.component';

const routes: Routes = [

    {
        path: 'search',
        component: MainSearchPageComponent
    },
    {
        path: 'for-sale',
        component: ForSalePagesComponent
    },
    {
        path:'post-an-add',
        component:PostAddComponent
    },
    {
        path: '**',
        redirectTo: '/',
        pathMatch: 'full'
    }
]
@NgModule({
    imports: [RouterModule.forRoot(routes, { useHash: true })],
    exports: [RouterModule]
})
export class YelloPagesWebRoutingModule { }
