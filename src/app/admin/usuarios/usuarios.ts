import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  standalone: true,
  selector: 'app-usuarios',
  templateUrl: './usuarios.html',
  styleUrls: ['./usuarios.scss'],
  imports: [CommonModule, FormsModule],
})
export class UsuariosComponent {
  usuarios: any[] = [
    {
      tipo: 'alumno',
      nombre: 'Ana Martínez',
      email: 'ana@edu.com',
      cursos: 3,
      esDelegado: false,
    },
    {
      tipo: 'profesor',
      nombre: 'Juan Pérez',
      email: 'juan@edu.com',
      especialidad: 'Matemáticas',
    },
  ];

  mostrarModal = false;
  modoEdicion = false;
  indexEdicion: number | null = null;

  usuarioActual: any = {};

  abrirModal() {
    this.modoEdicion = false;
    this.usuarioActual = {
      tipo: 'alumno',
      nombre: '',
      email: '',
      cursos: 0,
      esDelegado: false,
      especialidad: '',
    };
    this.indexEdicion = null;
    this.mostrarModal = true;
  }

  editarUsuario(index: number) {
    this.modoEdicion = true;
    this.indexEdicion = index;
    this.usuarioActual = { ...this.usuarios[index] };
    this.mostrarModal = true;
  }

  eliminarUsuario(index: number) {
    if (confirm('¿Estás seguro de eliminar este usuario?')) {
      this.usuarios.splice(index, 1);
    }
  }

  cerrarModal() {
    this.mostrarModal = false;
  }

  guardarUsuario() {
    if (this.modoEdicion && this.indexEdicion !== null) {
      this.usuarios[this.indexEdicion] = { ...this.usuarioActual };
    } else {
      this.usuarios.push({ ...this.usuarioActual });
    }
    this.cerrarModal();
  }
}
