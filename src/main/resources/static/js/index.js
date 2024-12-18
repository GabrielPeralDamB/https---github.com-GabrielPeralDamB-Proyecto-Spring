import * as THREE from 'https://cdn.jsdelivr.net/npm/three@0.118/build/three.module.js';
import { GLTFLoader } from 'https://cdn.jsdelivr.net/npm/three@0.118.1/examples/jsm/loaders/GLTFLoader.js';
import { OrbitControls } from 'https://cdn.jsdelivr.net/npm/three@0.118/examples/jsm/controls/OrbitControls.js';
import { BasicCharacterController } from './character.js';
import { Wall } from './muros.js';

class App {
  constructor() {
    this._Initialize();
  }

  _Initialize() {
    this._threejs = new THREE.WebGLRenderer({
      antialias: true,
    });
    this._threejs.outputEncoding = THREE.sRGBEncoding;
    this._threejs.shadowMap.enabled = true;
    this._threejs.shadowMap.type = THREE.PCFSoftShadowMap;
    this._threejs.setPixelRatio(window.devicePixelRatio);
    this._threejs.setSize(window.innerWidth, window.innerHeight);

    document.body.appendChild(this._threejs.domElement);

    window.addEventListener('resize', () => {
      this._OnWindowResize();
    }, false);

    const fov = 60;
    const aspect = 1920 / 1080;
    const near = 1.0;
    const far = 10000.0;
    this._camera = new THREE.PerspectiveCamera(fov, aspect, near, far);
    this._camera.position.set(25, 10, 25);

    this._scene = new THREE.Scene();
    let light= null;
    /*let light = new THREE.DirectionalLight(0xFFFFFF, 1.0);
    light.position.set(-100, 100, 100);
    light.target.position.set(0, 0, 0);
    light.castShadow = true;
    light.shadow.bias = -0.001;
    light.shadow.mapSize.width = 4096;
    light.shadow.mapSize.height = 4096;
    light.shadow.camera.near = 0.1;
    light.shadow.camera.far = 500.0;
    light.shadow.camera.left = 50;
    light.shadow.camera.right = -50;
    light.shadow.camera.top = 50;
    light.shadow.camera.bottom = -50;*/
    //this._scene.add(light);

    light = new THREE.AmbientLight(0xFFFFFF, 0.25);
    this._scene.add(light);

    // Remove OrbitControls
    // const controls = new OrbitControls(this._camera, this._threejs.domElement);
    // controls.target.set(0, 10, 0);
    // controls.update();

    const plane = new THREE.Mesh(
      new THREE.PlaneGeometry(500, 500, 1, 1),
      new THREE.MeshStandardMaterial({
        color: 0x00FF00, // Changed color to green
      })
    );
    plane.castShadow = false;
    plane.receiveShadow = true;
    plane.rotation.x = -Math.PI / 2;
    this._scene.add(plane);

    this._mixers = [];
    this._previousRAF = null;

    this._videoElement = null;
    this._walls = [];
    this._CreateWalls();
    this._LoadModel();
    this._LoadCharacter();
    this._LoadVideoPlane();
    this._LoadImagePlane();
    this._RAF();
  }

  _CreateWalls() {

    //paredes inicio
    let wall1 = null;/*new Wall(this._scene, new THREE.Vector3(30, 1, 10), new THREE.Vector3(1, 2, 10));
    this._walls.push(wall1);*/

    wall1 = new Wall(this._scene, new THREE.Vector3(17.4, 1, 12.5), new THREE.Vector3(14.7, 2, 14.7));
    this._walls.push(wall1);

    wall1 = new Wall(this._scene, new THREE.Vector3(17.4, 1, -12.5), new THREE.Vector3(14.7, 2, 14.7));
    this._walls.push(wall1);
    
    //1er pasillo
    //puestos frutas
    wall1 = new Wall(this._scene, new THREE.Vector3(40, 1, -1.2), new THREE.Vector3(13, 2, 7));
    this._walls.push(wall1);

    wall1 = new Wall(this._scene, new THREE.Vector3(40, 1, -1.2), new THREE.Vector3(15, 2, 4));
    this._walls.push(wall1);

    wall1 = new Wall(this._scene, new THREE.Vector3(64.8, 1, 1.3), new THREE.Vector3(13, 2, 7));
    this._walls.push(wall1);

    wall1 = new Wall(this._scene, new THREE.Vector3(64.8, 1, 1.3), new THREE.Vector3(15, 2, 4));
    this._walls.push(wall1);

    //Cajas amontonadas
    wall1 = new Wall(this._scene, new THREE.Vector3(43, 1, 8), new THREE.Vector3(1.5, 2, 1.5));
    this._walls.push(wall1);

    //Estanterias derecha
    wall1 = new Wall(this._scene, new THREE.Vector3(35, 1, 13.6), new THREE.Vector3(30, 2, 1));
    this._walls.push(wall1);

    //pared derecha
    wall1 = new Wall(this._scene, new THREE.Vector3(55, 1, 15), new THREE.Vector3(9.5, 2, 9.5));
    this._walls.push(wall1);

    //estanterias fondo derecha
    wall1 = new Wall(this._scene, new THREE.Vector3(64, 1, 14.5), new THREE.Vector3(12.5, 2, 5));
    this._walls.push(wall1);

    //pared izquierda
    wall1 = new Wall(this._scene, new THREE.Vector3(34, 1, -15.6), new THREE.Vector3(20, 2, 1));
    this._walls.push(wall1);

    wall1 = new Wall(this._scene, new THREE.Vector3(45, 1, -16), new THREE.Vector3(2, 2, 1));
    this._walls.push(wall1);

    wall1 = new Wall(this._scene, new THREE.Vector3(47, 1, -17), new THREE.Vector3(2, 2, 1));
    this._walls.push(wall1);

    wall1 = new Wall(this._scene, new THREE.Vector3(49, 1, -18), new THREE.Vector3(2, 2, 1));
    this._walls.push(wall1);


    //mostrador

    wall1 = new Wall(this._scene, new THREE.Vector3(72, 1, -13), new THREE.Vector3(33, 2, 2));
    this._walls.push(wall1);

    wall1 = new Wall(this._scene, new THREE.Vector3(86.5, 1, 0), new THREE.Vector3(2, 2, 23));
    this._walls.push(wall1);

    wall1 = new Wall(this._scene, new THREE.Vector3(88.5, 1, 13), new THREE.Vector3(2, 2, 7));
    this._walls.push(wall1);

    wall1 = new Wall(this._scene, new THREE.Vector3(93, 1, 38), new THREE.Vector3(2, 2, 24));
    this._walls.push(wall1);
    
    
    

    







    //pared Caja
     wall1 = new Wall(this._scene, new THREE.Vector3(10.2, 1, 37.5), new THREE.Vector3(30, 2, 4.7));
    this._walls.push(wall1);
    
  }

  _LoadModel() {
    const loader = new GLTFLoader();
    loader.load('/assets/modelos/Establecimiento/scene.gltf', (gltf) => {
      gltf.scene.traverse(c => {
        c.castShadow = true;
        if (c.material) {
          //c.material.transparent = true;
          //c.material.opacity = 0.5; // Set transparency
        }
      });
      gltf.scene.position.y = 0.01; // Position the model above the plane
      this._scene.add(gltf.scene);
    });

    loader.load('/assets/modelos/Goku/scene.gltf', (gltf) => {
      gltf.scene.traverse(c => {
        c.castShadow = true;
      });
      gltf.scene.scale.set(10, 10, 10);
      gltf.scene.rotation.y =Math.PI/2;
      // Scale the model
      gltf.scene.position.set(15, 0.01, 25); // Position the model on the plane
      this._scene.add(gltf.scene);
    });

    loader.load('/assets/modelos/KameHouse/scene.gltf', (gltf) => {
      gltf.scene.traverse(c => {
        c.castShadow = true;
      });
      gltf.scene.scale.set(1, 1, 1);
      gltf.scene.rotation.y = Math.PI/2;
      // Scale the model
      gltf.scene.position.set(-85, 10, -25); // Position the model on the plane
      this._scene.add(gltf.scene);
    });

    loader.load('/assets/modelos/pamborguini/packAgua/scene.gltf', (gltf) => {
      gltf.scene.traverse(c => {
        c.castShadow = true;
      });
      gltf.scene.scale.set(5, 5, 5);
      gltf.scene.rotation.y =Math.PI/2;
      // Scale the model
      gltf.scene.position.set(20, 0.01, 30); 
     // Position the model on the plane
      this._scene.add(gltf.scene);

      let aguaModel = gltf.scene.clone();
      aguaModel.position.set(13, 0.01, 20);
      aguaModel.rotation.y =Math.PI;
      //aguaModel.rotation.y=Math.PI;
      this._scene.add(aguaModel);

      let agua3Model = gltf.scene.clone();
      agua3Model.position.set(17, 0.01, 22);
      agua3Model.rotation.y =Math.PI;
      //gua3Model.rotation.y=Math.PI;
      this._scene.add(agua3Model);
    });
  }

  _LoadCharacter() {
    const params = {
      camera: this._camera,
      scene: this._scene,
    };
    this._controls = new BasicCharacterController(params);
  }

  _LoadVideoPlane() {
    const video = document.createElement('video');
    video.src = '/assets/modelos/pamborguini/pamborghini.mp4';
    video.loop = true;
    
    this._videoElement = video;

    const videoTexture = new THREE.VideoTexture(video);
    videoTexture.minFilter = THREE.LinearFilter;
    videoTexture.magFilter = THREE.LinearFilter;
    videoTexture.format = THREE.RGBFormat;

    const videoMaterial = new THREE.MeshBasicMaterial({ map: videoTexture });
    const videoGeometry = new THREE.PlaneGeometry(8, 4);
    const videoMesh = new THREE.Mesh(videoGeometry, videoMaterial);
    videoMesh.position.set(9.5, 4, 9.5);
    videoMesh.rotation.y = -Math.PI / 2;

    this._scene.add(videoMesh);
    
    document.body.addEventListener('click', () => {
      video.play();
    }
    );
  }

  _LoadImagePlane() {
    const textureLoader = new THREE.TextureLoader();
    const imageTexture = textureLoader.load('/assets/modelos/pamborguini/pamborghini.png');

    const imageMaterial = new THREE.MeshBasicMaterial({ map: imageTexture });
    const imageGeometry = new THREE.PlaneGeometry(4, 8);
    const imageMesh = new THREE.Mesh(imageGeometry, imageMaterial);
    imageMesh.position.set(9.5, 5, 16);
    imageMesh.rotation.y = -Math.PI / 2;

    this._scene.add(imageMesh);
  }

  _OnWindowResize() {
    this._camera.aspect = window.innerWidth / window.innerHeight;
    this._camera.updateProjectionMatrix();
    this._threejs.setSize(window.innerWidth, window.innerHeight);
  }

  _RAF() {
    requestAnimationFrame((t) => {
      if (this._previousRAF === null) {
        this._previousRAF = t;
      }

      this._RAF();

      this._threejs.render(this._scene, this._camera);
      this._Step(t - this._previousRAF);
      this._previousRAF = t;
    });
  }

  _Step(timeElapsed) {
    const timeElapsedS = timeElapsed * 0.001;
    if (this._mixers) {
      this._mixers.map(m => m.update(timeElapsedS));
    }

    if (this._controls) {
      this._controls.Update(timeElapsedS);
    }

    this._UpdateVideoVolume();
    this._CheckCollisions();
  }

  _CheckCollisions() {
    const characterPosition = this._controls.GetPosition();
    for (const wall of this._walls) {
      if (wall.CheckCollision(characterPosition)) {
        this._controls.HandleCollision();
      }
    }
  }

  _UpdateVideoVolume() {
    if (this._videoElement) {
      const videoPosition = new THREE.Vector3(9.5, 4, 9.5);
      const distance = this._camera.position.distanceTo(videoPosition);
      const maxDistance = 20; // Maximum distance at which the video is audible
      const volume = Math.max(0, 1 - distance / maxDistance);
      this._videoElement.volume = volume;
    }
  }
}

let _APP = null;

window.addEventListener('DOMContentLoaded', () => {
  _APP = new App();
});
