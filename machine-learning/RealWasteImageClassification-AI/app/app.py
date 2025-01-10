import gradio as gr
import tensorflow as tf
from tensorflow.keras.models import load_model
import numpy as np
from tensorflow.keras.preprocessing import image

# Memuat model yang telah dilatih
model_keenam = load_model('hasil_model.h5')

# Fungsi untuk memproses gambar dan membuat prediksi
def predict_image(img):
    # Mengubah ukuran gambar sesuai dengan input model
    img = img.resize((255, 255))
    
    # Mengkonversi gambar menjadi array numpy dan normalisasi
    img_array = np.array(img) / 255.0
    
    # Memperluas dimensi untuk batch size (model membutuhkan input batch)
    img_array = np.expand_dims(img_array, axis=0)
    
    # Melakukan prediksi
    predictions = model_keenam.predict(img_array)
    
    # Mendapatkan indeks kelas dengan probabilitas tertinggi
    class_names = ['Cardboard', 'Food Organics', 'Glass', 'Metal', 'Miscellaneous Trash']
    predicted_class = class_names[np.argmax(predictions)]
    
    return predicted_class, np.max(predictions)

# Membuat antarmuka Gradio
iface = gr.Interface(
    fn=predict_image, 
    inputs=gr.Image(type='pil'),  # Menggunakan input gambar
    outputs=[gr.Label(num_top_classes=1), gr.Textbox()],  # Menampilkan label dan probabilitas
    live=True,  # Memungkinkan prediksi langsung saat gambar diupload
    title="Prediksi Klasifikasi Sampah",  # Judul aplikasi
    description="Upload gambar sampah untuk mendapatkan prediksi klasifikasi berdasarkan model."
)

# Menjalankan antarmuka
iface.launch()