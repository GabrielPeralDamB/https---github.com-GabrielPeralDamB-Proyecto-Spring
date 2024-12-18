import * as THREE from 'https://cdn.jsdelivr.net/npm/three@0.118/build/three.module.js';

export class Wall {
  constructor(scene, position, size, visible = false) {
    this._scene = scene;
    this._position = position;
    this._size = size;
    this._visible = visible;
    this._CreateWall();
  }

  _CreateWall() {
    const geometry = new THREE.BoxGeometry(this._size.x, this._size.y, this._size.z);
    const material = new THREE.MeshStandardMaterial({ color: 0x808080 });
    this._mesh = new THREE.Mesh(geometry, material);
    this._mesh.position.set(this._position.x, this._position.y, this._position.z);
    this._mesh.castShadow = true;
    this._mesh.receiveShadow = true;
    this._mesh.visible = this._visible; // Set visibility based on the constructor parameter
    this._scene.add(this._mesh);
  }

  CheckCollision(characterPosition) {
    const wallBox = new THREE.Box3().setFromObject(this._mesh);
    return wallBox.intersectsBox(new THREE.Box3().setFromCenterAndSize(characterPosition, new THREE.Vector3(1, 2, 1)));
  }
}
