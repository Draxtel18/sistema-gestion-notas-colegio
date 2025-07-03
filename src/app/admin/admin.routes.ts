import { Routes } from '@angular/router';
import { Sidebar } from './sidebar/sidebar';
import { DashboardComponent } from './dashboard/dashboard';
import { UsuariosComponent } from './usuarios/usuarios';
import { Cursos } from './cursos/cursos';
import { Horarios } from './horarios/horarios';
import { Delegados } from './delegados/delegados';

export const ADMIN_ROUTES: Routes = [
  {
    path: '',
    component: Sidebar,
    children: [
      { path: 'dashboard', component: DashboardComponent },
      { path: 'usuarios', component: UsuariosComponent },
      { path: 'cursos', component: Cursos },
      { path: 'horarios', component: Horarios },
      { path: 'delegados', component: Delegados },
    ],
  },
];
