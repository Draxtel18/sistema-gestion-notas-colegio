import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  selector: 'app-dashboard',
  templateUrl: './dashboard.html',
  styleUrls: ['./dashboard.scss'],
  imports: [CommonModule],
})
export class DashboardComponent {
  totalEstudiantes = 2;
  totalCursos = 2;
  totalProfesores = 1;
  totalDelegados = 1;

  resumen = [
    {
      label: 'Total Estudiantes',
      valor: this.totalEstudiantes,
      sub: 'Estudiantes activos',
      icon: '🎓',
    },
    {
      label: 'Total Cursos',
      valor: this.totalCursos,
      sub: 'Cursos disponibles',
      icon: '📚',
    },
    {
      label: 'Profesores',
      valor: this.totalProfesores,
      sub: 'Profesores activos',
      icon: '🧑‍🏫',
    },
    {
      label: 'Delegados',
      valor: this.totalDelegados,
      sub: 'Delegados de clase',
      icon: '🗂️',
    },
  ];

  accionesRecientes = [
    {
      titulo: 'Nuevo estudiante registrado',
      descripcion: 'Ana Martínez - hace 2 horas',
      color: 'verde', // lo cambias a clase SCSS
    },
    {
      titulo: 'Curso actualizado',
      descripcion: 'Matemáticas Avanzadas - hace 4 horas',
      color: 'azul',
    },
    {
      titulo: 'Horario asignado',
      descripcion: 'Historia Universal - hace 1 día',
      color: 'morado',
    },
  ];
}
