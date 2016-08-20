package com.example.regina.medshare;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SummonDB extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "";
    private static int VERSAO = 1;
    //private static SQLiteDatabase bd;

    public SummonDB (Context context) {
        super(context, DATABASE_NAME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("CREATE TABLE IF NOT EXISTS `aluguel` ( `aluguel_id` int(11) NOT NULL,`cliente` varchar(20) NOT NULL,`fornecedor` varchar(20) NOT NULL,`data_retirada` date NOT NULL,`data_prazo` date NOT NULL,`data_devolucao` date DEFAULT NULL);");

        bd.execSQL("CREATE TABLE IF NOT EXISTS `avaliacao_usuario` (`avaliacao_fornecedor_id` int(11) NOT NULL,`fornecedor` varchar(50) NOT NULL,`nota` int(11) NOT NULL);");

        bd.execSQL("CREATE TABLE IF NOT EXISTS `produto` (`produto_id` int(11) NOT NULL,`produto_nome` text NOT NULL,`marca` text NOT NULL,`tipo` int(11) NOT NULL,`descricao` text NOT NULL,`foto` text NOT NULL,`fornecedor` varchar(50) NOT NULL`transacao` int(11) NOT NULL,`disponivel` tinyint(1) NOT NULL,`novo` tinyint(1) NOT NULL);");

        bd.execSQL("CREATE TABLE IF NOT EXISTS `produto_aluguel` (`produto_id` int(11) NOT NULL,`preco_aluguel` decimal(3,2) NOT NULL,`frequencia` varchar(20) NOT NULL);");

        bd.execSQL("CREATE TABLE IF NOT EXISTS `produto_venda` (`produto_id` int(11) NOT NULL,`preco` decimal(3,2) NOT NULL,`data_venda` date DEFAULT NULL,`cliente` varchar(50) DEFAULT NULL);");

        bd.execSQL("CREATE TABLE IF NOT EXISTS `tipo` (`tipo_id` int(11) NOT NULL,`tipo_nome` text NOT NULL);");

        bd.execSQL("CREATE TABLE IF NOT EXISTS `usuario` (`email` varchar(50) NOT NULL,`nome` text NOT NULL,`CPF` text NOT NULL,`RG` text NOT NULL,`senha` text NOT NULL,`pais` text NOT NULL,`estado` text NOT NULL,`cidade` text NOT NULL,`bairro` text NOT NULL,`CEP` text NOT NULL,`rua` text NOT NULL);");

        bd.execSQL("ALTER TABLE `aluguel` ADD PRIMARY KEY (`aluguel_id`);");

        bd.execSQL("ALTER TABLE `avaliacao_usuario` ADD PRIMARY KEY (`avaliacao_fornecedor_id`);");

        bd.execSQL("ALTER TABLE `produto` ADD PRIMARY KEY (`produto_id`);");

        bd.execSQL("ALTER TABLE `produto_aluguel` ADD PRIMARY KEY (`produto_id`);");

        bd.execSQL("ALTER TABLE `produto_venda` ADD PRIMARY KEY (`produto_id`);");

        bd.execSQL("ALTER TABLE `tipo` ADD PRIMARY KEY (`tipo_id`);");

        bd.execSQL("ALTER TABLE `usuario` ADD PRIMARY KEY (`email`);");

        bd.execSQL("ALTER TABLE `avaliacao_usuario` MODIFY `avaliacao_fornecedor_id` int(11) NOT NULL AUTO_INCREMENT;");

        bd.execSQL("ALTER TABLE `produto` MODIFY `produto_id` int(11) NOT NULL AUTO_INCREMENT;");

        bd.execSQL("ALTER TABLE `tipo` MODIFY `tipo_id` int(11) NOT NULL AUTO_INCREMENT;");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
