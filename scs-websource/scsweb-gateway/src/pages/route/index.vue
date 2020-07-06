<template>
  <div>
    <el-form :inline="true" :model="routeQuery">
      <el-form-item label="ID/名称">
        <el-input v-model="routeQuery.idname" placeholder="ID/名称"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="doQuery">查询</el-button>
        <el-button type="primary" @click="routeAdd">新增</el-button>
        <el-button type="success" @click="refreshRoute">刷新路由</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="routers" style="width: 100%">
      <el-table-column prop="id" label="ID"></el-table-column>
      <el-table-column prop="name" label="名称"></el-table-column>
      <el-table-column prop="url" label="URL"></el-table-column>
      <el-table-column prop="predicates" label="predicates"></el-table-column>
      <el-table-column prop="filters" label="filters"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="routeEdit(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="routeDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="路由信息" :visible.sync="routeDialogVisible" width="500" height="350">
      <el-form :model="routeForm" ref="routeForm">
        <el-form-item
          label="ID"
          prop="id"
          :label-width="routeFormLabelWidth"
          :rules="{  required: true, message: 'ID不能为空', trigger: 'blur' }"
        >
          <el-input v-model="routeForm.id"></el-input>
        </el-form-item>
        <el-form-item
          label="名称"
          prop="name"
          :label-width="routeFormLabelWidth"
          :rules="{  required: true, message: '名称不能为空', trigger: 'blur' }"
        >
          <el-input v-model="routeForm.name"></el-input>
        </el-form-item>
        <el-form-item
          label="URL"
          prop="url"
          :label-width="routeFormLabelWidth"
          :rules="{  required: true, message: 'URL不能为空', trigger: 'blur' }"
        >
          <el-input v-model="routeForm.url"></el-input>
        </el-form-item>
        <!-- predicate -->
        <el-form-item
          v-for="(predicate, index) in routeForm.predicatesList"
          :label="'predicate_' + index"
          :label-width="routeFormLabelWidth"
          :key="'predicate_' +index"
          :prop="'predicatesList.' + index + '.key'"
          :rules="{ required: true, message: '不能为空', trigger: 'blur' }"
        >
          <el-row>
            <el-col :span="6">
              <el-autocomplete
                class="inline-input"
                v-model="predicate.key"
                :fetch-suggestions="predicateQuerySearch"
                placeholder="请输入内容"
              ></el-autocomplete>
            </el-col>
            <el-col :span="14">
              <el-input v-model="predicate.value" autocomplete="off"></el-input>
            </el-col>
            <el-col :span="2">
              <el-button @click.prevent="removeRoutePredicate(predicate)">删除</el-button>
            </el-col>
          </el-row>
        </el-form-item>
        <!-- filter -->
        <el-form-item
          v-for="(filter, index) in routeForm.filtersList"
          :label="'filter_' + index"
          :label-width="routeFormLabelWidth"
          :key="'filter_'+index"
          :prop="'filtersList.' + index + '.key'"
          :rules="{ required: true, message: '不能为空', trigger: 'blur' }"
        >
          <el-row>
            <el-col :span="6">
              <el-autocomplete
                class="inline-input"
                v-model="filter.key"
                :fetch-suggestions="filterQuerySearch"
                placeholder="请输入内容"
              ></el-autocomplete>
            </el-col>
            <el-col :span="14">
              <el-input v-model="filter.value" autocomplete="off"></el-input>
            </el-col>
            <el-col :span="2">
              <el-button @click.prevent="removeRouteFilter(filter)">删除</el-button>
            </el-col>
          </el-row>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addPredicateList">新增predicate</el-button>
        <el-button @click="addFilterList">新增filter</el-button>
        <el-button @click="routeDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="postRouter">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script src="./index.js"></script>
