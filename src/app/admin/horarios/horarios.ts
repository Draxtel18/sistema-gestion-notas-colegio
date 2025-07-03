import { Component } from '@angular/core';

@Component({
  selector: 'app-horarios',
  standalone: true,
  imports: [],
  templateUrl: './horarios.html',
  styleUrl: './horarios.scss'
})
export class Horarios {
  horarios = [
    { curso: 'Matemáticas', dia: 'Lunes', hora: '08:00 - 09:30', aula: 'A101', profesor: 'Prof. García' },
    { curso: 'Comunicación', dia: 'Martes', hora: '10:00 - 11:30', aula: 'B201', profesor: 'Prof. Rojas' },
    { curso: 'Historia', dia: 'Miércoles', hora: '11:30 - 13:00', aula: 'C102', profesor: 'Prof. Salazar' }
  ];
}
