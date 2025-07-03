import { Component } from '@angular/core';

@Component({
  selector: 'app-cursos',
  standalone: true,
  imports: [],
  templateUrl: './cursos.html',
  styleUrl: './cursos.scss'
})
export class Cursos {
  cursos = [
    { nombre: 'Matemáticas', codigo: 'MAT101', creditos: 4, profesor: 'Juan Pérez', aula: 'A-101', horario: 'Lun-Mié 8-10am' },
    { nombre: 'Historia', codigo: 'HIS201', creditos: 3, profesor: 'María Díaz', aula: 'B-202', horario: 'Mar-Jue 10-12pm' },
    { nombre: 'Física', codigo: 'FIS301', creditos: 5, profesor: 'Carlos López', aula: 'C-303', horario: 'Vie 2-6pm' }
  ];
}
