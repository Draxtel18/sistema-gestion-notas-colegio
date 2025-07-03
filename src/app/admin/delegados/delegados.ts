import { Component } from '@angular/core';

@Component({
  selector: 'app-delegados',
  standalone: true,
  imports: [],
  templateUrl: './delegados.html',
  styleUrl: './delegados.scss'
})
export class Delegados {
  delegados = [
    { curso: 'Matemáticas', nombre: 'Ana Pérez', correo: 'ana@ejemplo.com', telefono: '987654321', seccion: 'A' },
    { curso: 'Comunicación', nombre: 'Luis Vargas', correo: 'luis@ejemplo.com', telefono: '912345678', seccion: 'B' },
    { curso: 'Historia', nombre: 'María Díaz', correo: 'maria@ejemplo.com', telefono: '998877665', seccion: 'C' }
  ];
}
