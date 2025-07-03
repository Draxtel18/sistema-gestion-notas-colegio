// src/app/app.routes.ts
import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'alumno',
    loadChildren: () =>
      import('./alumno/alumno.routes').then((m) => m.ALUMNO_ROUTES),
  },
  {
    path: 'profesor',
    loadChildren: () =>
      import('./profesor/profesor.routes').then((m) => m.PROFESOR_ROUTES),
  },
  {
    path: 'admin',
    loadChildren: () =>
      import('./admin/admin.routes').then((m) => m.ADMIN_ROUTES),
  },
  {
    path: '',
    redirectTo: 'admin/dashboard',
    pathMatch: 'full',
  },
  {
    path: '**',
    redirectTo: 'admin/dashboard',
  },
];
